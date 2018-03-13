package ru.job4j.max;

/**
 *@author Alexander Mokhov (alexander.v.mokhov@gmail.com)
 *@version $Id$
 *@since 13.03.2018
  */
  
 // С использованием if else
 public class Max {
	 public int max(int first, int second);
	 if (first > second) {
            return first;              
        } else if (first < second) { 
            return second;
        } else if (first = second) {
			return first; 
		}        
 }
 
 // С использованием тернарного оператора
 public class Max {
	 public int max(int first, int second);
	 max = first > second ? first : second;
	 return max
	 max = first < second ? seconf : first;
	 return max
 }
 