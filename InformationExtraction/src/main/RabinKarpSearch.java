package main;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *  RabinKarpSearch class finds the list of occurrences of a pattern string in a text string.
 *  This implementation uses the Rabin-Karp algorithm (https://algs4.cs.princeton.edu/53substring/RabinKarp.java.html).
 */
public class RabinKarpSearch {
    private String text;      // the text to be parsed and searched in
    private String pat;      // the pattern to be searched
	private long patHash;    // pattern hash value
    private int n;           // text length
    private int m;           // pattern length
    private long q;          // a large prime, small enough to avoid long overflow
    private int R;           // radix
    private long RM;         // R^(M-1) % Q

    /**
     * Preprocesses the pattern string.
     *
     * @param pattern the pattern string
     * @param R the alphabet size
     */
    public RabinKarpSearch(String text, int R) {
    	this(text);
    	this.R = R;
    }

    /**
     * Preprocesses the text.
     *
     * @param pat the pattern string
     */
    public RabinKarpSearch(String text) {
        this.text = text;      // save text
        n=text.length();
        R = 256;
        q = longRandomPrime();
    }

    // To set pattern and variables
	private void setPat(String pat) {
		this.pat = pat;
    	m = pat.length();
    	
        // pre-compute R^(m-1) % q for use in removing leading digit
        RM = 1;
        for (int i = 1; i <= m-1; i++)
            RM = (R * RM) % q;
        patHash = hash(pat, m);
	}
    
    public String getPat() {
		return pat;
	}

    // Compute hash for key[0..m-1].
    private long hash(String key, int m) {
        long h = 0; 
        for (int j = 0; j < m; j++) 
            h = (R * h + key.charAt(j)) % q;
        return h;
    }

    // Does pat[] match text[i..i-m+1] ?
    private boolean check(int i) {
        for (int j = 0; j < pat.length(); j++) 
            if (pat.charAt(j) != text.charAt(i + j)) 
                return false; 
        return true;
    }

    // a random 31-bit prime
    private static long longRandomPrime() {
        BigInteger prime = BigInteger.probablePrime(31, new Random());
        return prime.longValue();
    }
 
    /**
     * Finds the index of the first occurrence of the pattern string
     * in the text string from beginIndex.
     * pattern (variable pat) needs to be set via setPat(String pat) before calling this method
     * 
     * @param  int beginIndex (offset) to start searching for pattern in text
     * @param pat pattern to be searched
     * @return the index of the first occurrence of the pattern string
     *         in the text string; -1 if no such match
     */
    
    public int findFromIndex(int beginIndex, String pat) {
    	setPat(pat);
    	final int l = text.substring(beginIndex).length(); // length of searchable part of text
        if (l < m)
        	return -1;
        
        long textHash = hash(text.substring(beginIndex), m);

        // check for match at beginIndex
        if ((patHash == textHash) && check(beginIndex))
            return beginIndex;

        // check for hash match; if hash match, check for exact match
        for (int i = beginIndex+m; i < n; i++) {
            // Remove leading digit, add trailing digit, check for match
        	textHash = (textHash + q - RM*text.charAt(i-m) % q) % q; 
        	textHash = (textHash*R + text.charAt(i)) % q; 

            // match
            int offset = i - m + 1;
            if ((patHash == textHash) && check(offset))
                return offset;
        }
        
        // There is no match
        return -1;
    }
     
    /**
     * Finds the list of all occurrences (indexes) of the pattern string 
     * in text
     *
     * @param  pat pattern string
     * @return the list of indexes of occurrences of the pattern string
     *         in the text string;
     */
    
    public List<Integer> findAll(String pat) {
        
        int occurence, beginIndex=0;
        List<Integer> occurenceList = new ArrayList<Integer>();

        do {
    		occurence = findFromIndex(beginIndex, pat);
    		occurenceList.add(occurence);
    		beginIndex=occurence+pat.length();
        } while(occurence > 0 && occurence < n-pat.length());
        
     // Remove last index from occurenceList, if its value is -1 
        if(occurenceList.get(occurenceList.size()-1) == -1)
        	occurenceList.remove(occurenceList.size()-1);
        
    	return occurenceList;
    }
}