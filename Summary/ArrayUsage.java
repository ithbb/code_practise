/*

ArrayUsage for array.length

Before Initialization
Card Array length = 5
After Initialization
Card Array length = 5

*/

package com.starkaku.javabasic;

import java.util.Comparator;

public class ArrayUsage {

	public Card[] cardArray = new Card[5];
	
	
	public ArrayUsage() {
		System.out.println("Before Initialization");
		System.out.println("Card Array length = " + cardArray.length);
		cardArray[0] = new Card(CardColor.HEART, 5);
		cardArray[1] = new Card(CardColor.SPADE, 3);
		System.out.println("After Initialization");
		System.out.println("Card Array length = " + cardArray.length);

	}
	
	public static void main(String[] args) {
		ArrayUsage exam = new ArrayUsage();
	}


	private enum CardColor {

	    DIAMOND,
	    CLUB,
	    HEART,
	    SPADE

	}
 
	private static class Card {

	    private CardColor color;

	    private int point;

	    public Card(CardColor color, int point) {
	        this.color = color;
	        this.point = point;
	    }

	    private static class CardComparator implements Comparator<Card> {

	        @Override
	        public int compare(Card c1, Card c2) {

	            if (c1.point > c2.point) {
	                return 1;
	            } else if (c1.point < c2.point) {
	                return -1;
	            } else {
	                if (c1.color.ordinal() > c2.color.ordinal()) {
	                    return 1;
	                } else if (c1.color.ordinal() < c2.color.ordinal()) {
	                    return -1;
	                }
	            }
	            return 0;
	        }
	    }

	}

}
