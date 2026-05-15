package othercontainer;

import java.util.BitSet;

public class BitSetTest {
	public static String toBinary(BitSet bitSet) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i != bitSet.length(); ++i) {
			sb.append(bitSet.get(i)?1:0);
		}
		return sb.toString();
	}
	
	public static void printBitSets(BitSet bitSet1, BitSet bitSet2) {
		System.out.println("bitSet1: " + toBinary(bitSet1));
		System.out.println("bitSet2: " + toBinary(bitSet2));
	}
	
	public static void main(String args[]) {
		BitSet bitset1 = new BitSet();
		// holds sequence of bits, initially all zero
		System.out.println("Print all Bits that are set to 1: " + bitset1);
		bitset1.set(10);
		bitset1.set(1);
		bitset1.set(0);
		System.out.println("Print all Bits that are set to 1: " + bitset1);

		System.out.println("Print binary representation of bitSet (first bit on the left): " + toBinary(bitset1));

		BitSet bitset2 = new BitSet();
		bitset2.set(4);
		
		System.out.println("Before OR: ");
		printBitSets(bitset1, bitset2);
		
		bitset1.or(bitset2);
		System.out.println("After OR: ");
		printBitSets(bitset1, bitset2);
	}
}
