/*
 *  Daria Duminska
 *  Copyright (c) 2019 All Rights Reserved.
 *
 */

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Class Cosmetics represents entity in the storage.
 *
 * @version 1.0 30 Sept 2019
 * @author Daria Duminska
 */

public class Cosmetics {

    /**
     *  Types of products that may be present in the storage.
     */
    public enum CosmeticsType {
        Foundation,
        Mascara,
        Eyeliner
    }

    /**
     *  Producers whose cosmetics may be present in the storage.
     */
    public enum Producers {
        prod1,
        prod2,
        prod3
    }

    /**
     * Type of this cosmetic product .
     */
    private CosmeticsType type;
    /**
     * Number of cosmetic products present at the moment.
     */
    private int amount;
    /**
     * Producer of this specific cosmetic product .
     */
    private Producers producer;
    /**
     * Flag that states if this cosmetic product was tested on animals.
     */
    private boolean testedOnAnimals;
    /**
     *  Date when the cosmetic product  expires and shouldn't be used.
     */
    private Date expirationDate;

    /**
     * Class constructor with all fields specified.
     * @param type type of this product. Must be one of the enum.
     * @param amount amount of product available at the moment.
     *              Must be greater/equal zero.
     * @param producer producer of this specific product.
     *                Must be one of the enum.
     * @param testedOnAnimals states if the product was tested
     *                        on animals. Is a boolean flag.
     * @param expirationDate date when the product expires. Date object.
     */
    public Cosmetics(final CosmeticsType type, final int amount,
                     final Producers producer, final boolean testedOnAnimals,
                     final Date expirationDate) {

        this.type = type;
        this.amount = amount;
        this.producer = producer;
        this.testedOnAnimals = testedOnAnimals;
        this.expirationDate = expirationDate;
    }

    /**
     *  Default constructor of the cosmetics entity. All values are random.
     *  Amount is not greater than 15, Expiration date is between
     *  2019-01-01 and 2021-12-12
     */
    public Cosmetics() {
        final int amountLimit = 15;
        this.type = getRandomType();
        this.amount = ThreadLocalRandom.current().nextInt(amountLimit);
        this.producer = getRandomProducer();
        this.testedOnAnimals = (ThreadLocalRandom.current().nextBoolean());
        this.expirationDate = new Date(ThreadLocalRandom.current()
                .nextLong(Timestamp.valueOf("2019-01-01 00:00:00").getTime(),
                        Timestamp.valueOf("2021-12-12 00:00:00").getTime()));
    }

    /**
     * Gets a random producer of the cosmetics.
     * @return random producer.
     */
    private static Producers getRandomProducer() {
        return Producers.values()[(ThreadLocalRandom.current())
                .nextInt(Producers.values().length)];
    }
    /**
     * Gets a random type of the cosmetics.
     * @return random type.
     */
    private static CosmeticsType getRandomType() {
        return CosmeticsType.values()[(ThreadLocalRandom.current())
                .nextInt(CosmeticsType.values().length)];
    }


    /**
     * Setter for the amount value.
     * @param amount amount of the product.
     * @return boolean flag stating whether we managed to assign the value.
     */
    public boolean setAmount(final int amount) {

        if (amount >= 0) {
            this.amount = amount;
            return true;
        }
        return false;
    }

    /**
     * Getter for the amount.
     * @return this cosmetics' amount.
     */
    public int getAmount() {
        return this.amount;

    }

    /**
     *  Setter for the type.
     * @param type type of the product. Is of the enum.
     */
    public void setType(final CosmeticsType type) {
        this.type = type;
    }

    /**
     * Getter for the type.
     * @return type of the product. Is of the enum.
     */
    public CosmeticsType getType() {
        return this.type;
    }

    /**
     * Setter for the producer.
     * @param producer producer of the product.
     */
    public void setProducer(final Producers producer) {
        this.producer = producer;
    }

    /**
     * Getter for the producer.
     * @return producer of the product.
     */
    public Producers getProducer() {
        return this.producer;
    }

    /**
     * Setter for being tested on animals flag.
     * @param tested boolean was tested on animals
     */
    public void setTestedOnAnimals(final boolean tested) {
        this.testedOnAnimals = tested;
    }

    /**
     * Getter for being tested on animals flag.
     * @return boolean was tested on animals
     */
    public boolean getTestedOnAnimals() {
        return this.testedOnAnimals;
    }


    /**
     * Setter for the expiration date.
     * @param date the expiration date.
     */
    public void setExpirationDate(final Date date) {
        this.expirationDate = date;
    }

    /**
     * Getter for the expiration date.
     * @return the expiration date.
     */
    public Date getExpirationDate() {
        return this.expirationDate;
    }

    /**
     * Prints the product's data. Uses System.out.println.
     */
    private void printObject() {
        System.out.println(//"Object \n Type: " + this.type +
                "\n Amount: " + this.amount //+ "\n Producer: " + this.producer
                        + "\n Tested on animals: "
                        + ((this.testedOnAnimals) ? "yes" : "no ")
                 + "\n Expiration date: " + this.expirationDate + "\n");

    }

    /**
     * Used to initialize an array of random Cosmetics objects.
     * @param array array to be initialized with Cosmetics objects.
     */
    private static void initArray(final Cosmetics[] array) {

        for (int i = 0; i < array.length; i++) {
            array[i] = new Cosmetics();
        }

    }

    /**
     * In the method we initialize an array of 8 random Cosmetics objects.
     * Afterwards they are sorted by 'testedOnAnimals' value in ascending order,
     * having 'amount' as the second parameter to be sorted
     * by in descending order. The resulting array is
     * printed via printObject method.
     * @param args arguments passed by command line
     *             while starting a program.
     */
    public static void main(final String[] args) {

        final int n = 8;

        Cosmetics[] cosmeticsArray = new Cosmetics[n];
        initArray(cosmeticsArray);

        Arrays.sort(cosmeticsArray, (Cosmetics t1, Cosmetics t2) -> {

            if (t1.testedOnAnimals == t2.testedOnAnimals
                    &&  (t1.amount < t2.amount)) {
                return 1;
            } else if (t1.testedOnAnimals && !t2.testedOnAnimals) {
                return 1;
            }
            return -1;

        });


        /**
         * Descending  sorting via amount
         */
       /* Arrays.sort(cosmeticsArray, (Cosmetics t1, Cosmetics t2) -> {

            if  (t1.amount < t2.amount) {
                return 1;
            } else if (t1.amount > t2.amount) {
                return -1;
            }
            return 0;

        });

        /**
         * Ascending sorting via expiration date
         */
       /* Arrays.sort(cosmeticsArray, (Cosmetics t1, Cosmetics t2) -> {

            if  (t1.expirationDate.after(t2.expirationDate)) {
                return 1;
            } else if (t1.expirationDate.before(t2.expirationDate)) {
                return -1;
            }
            return 0;

        });*/

        for (Cosmetics cosmetics : cosmeticsArray) {
            cosmetics.printObject();
        }

    }



}
