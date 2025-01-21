// Copyright 2025 stranger

package day00.ex04;

import java.util.*;

public class Program{
    public static void main(String[] args){
        buildHistogram(countingLetters());
    }

    static int[] countingLetters(){
        Scanner in = new Scanner(System.in);

        String line = in.nextLine();

        if(line.length() > 999){
            line = line.substring(0, 999);
        }

        int[] frequencyLetters = new int[65535];

        for(int index : line.toCharArray()){
            ++frequencyLetters[index];
        }

        return frequencyLetters;
    }

    static void buildHistogram(final int[] frequencyLetters){
        int uniqueLetters = 0;
        int maxFrequency = 0;

        for(int frequency : frequencyLetters){
            if(frequency > 0){
                ++uniqueLetters;
            }
        }

        for(int frequency : frequencyLetters){
            if(maxFrequency < frequency){
                maxFrequency = frequency;
            }
        }

        int[] letters = new int[uniqueLetters];
        int[] frequencies = new int[uniqueLetters];

        for(int i = 0, j = 0; i < frequencyLetters.length; ++i){
            final int temp = frequencyLetters[i];

            if(temp > 0){
                letters[j] = i;
                frequencies[j] = temp;

                ++j;
            }
        }

        sortLetters(letters, frequencies);

        printHistogram(letters, frequencies, maxFrequency, uniqueLetters);
    }

    static void sortLetters(int[] letters, int[] frequencies){
        for(int i = 0, length = letters.length; i < length; ++i){
            int maxIndex = i;

            for(int j = i; j < length; ++j){
                if(frequencies[maxIndex] < frequencies[j]){
                    maxIndex = j;
                }
                else if((frequencies[maxIndex] == frequencies[j]) &&
                        (letters[maxIndex] > letters[j])){
                    maxIndex = j;
                }
            }

            if(maxIndex != i){
                int temp1 = letters[i];
                int temp2 = frequencies[i];

                letters[i] = letters[maxIndex];
                frequencies[i] = frequencies[maxIndex];

                letters[maxIndex] = temp1;
                frequencies[maxIndex] = temp2;
            }
        }
    }

    static void printHistogram(final int[] letters, final int[] frequencies,
                               final int maxFrequency, int uniqueLetters){
        uniqueLetters = Math.min(uniqueLetters, 10);

        System.out.println();

        for(int i = 0; i < uniqueLetters; ++i){
            if(frequencies[i] == maxFrequency){
                System.out.print(maxFrequency + "\t");
            }
        }

        System.out.println();

        for(int i = uniqueLetters; i > 0; --i){
            for(int j = 0; j < uniqueLetters; ++j){
                final int temp = frequencies[j] * uniqueLetters / maxFrequency;

                if(temp == i - 1){
                    System.out.print(frequencies[j] + "\t");
                }

                if(temp >= i){
                    System.out.print("#\t");
                }
            }

            System.out.println();
        }

        for(int i = 0; i < uniqueLetters; ++i){
            System.out.print((char)letters[i] + "\t");
        }

        System.out.println();
    }
}