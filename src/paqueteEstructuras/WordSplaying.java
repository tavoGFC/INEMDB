package paqueteEstructuras;

import java.io.*;
/**
 *
 * @author Fernanda
 */
     class Word implements Comparable {
        private String word = "";
        public int freq = 1;
        public Word() {
        }
        public Word(String s) {
            word = s;
        }
        public boolean equals(Object el) {
            return word.equals(((Word)el).word);
        }
        public int compareTo(Object el) {
            return word.compareTo(((Word)el).word);
    
        }
        public String toString() {
            return word + ": " + freq + " ";
        }
        }
     	/*
     	 * funcion que contiene los elementos en el la misma fila
     	 */
        class WordSplay extends SplayTree {
            private int differentWords,wordCnt; 
            public WordSplay() {
                differentWords = wordCnt = 0;
            }
            protected void visit(BSTNode p) {
                differentWords++;
                wordCnt += ((Word)p.el).freq;
            }
            public void run(InputStream fIn, String fileName) {
                int ch = 1;Word p;
                try {
                    while (ch > -1) {
                        while (true)
                        if (ch > -1 && !Character.isLetter((char)ch)) // skip
                            ch = fIn.read(); // nonletters;
                        else break;
                    if (ch == -1)
                    break;
                    String s = "";
                    while (ch > -1 && Character.isLetter((char)ch)) {
                        s += Character.toUpperCase((char)ch);
                        ch = fIn.read();
                    }
                    if ((p = (Word)search(new Word(s))) == null)
                    insert(new Word(s));
                    else ((Word)p).freq++;
                    }
                } catch (IOException io) {
                System.err.println("A problem with input");
                }
                inorder();
                System.out.println("\n\nFile " + fileName+ " contains " + wordCnt + " words among which "+ differentWords + " are different\n");
            }
            }
        class WordSplaying {
            static public void main(String args[]) {
                String fileName = "";
                InputStream fIn;
                BufferedReader buffer = new BufferedReader(
                new InputStreamReader(System.in));
                try {
                    if (args.length == 0) {
                        System.out.print("Enter a file name: ");
                        fileName = buffer.readLine();
                        fIn = new FileInputStream(fileName);
                    }
                    else {
                        fIn = new FileInputStream(args[0]);
                        fileName = args[0];
                    }
                    (new WordSplay()).run(fIn,fileName);
                    fIn.close();
                    } catch(IOException io) {
                    System.err.println("Cannot open " + fileName);
                    }
            }
    }