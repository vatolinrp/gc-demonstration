package com.vatolinrp.gc;

import javassist.CannotCompileException;
import javassist.ClassPool;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class MetaspaceController
{
  private static ClassPool classPool;
  private static int classesCounter;

  public static void main( String[] args ) throws Exception
  {
    classPool = new ClassPool().getDefault();
    BufferedReader in = new BufferedReader( new InputStreamReader( System.in ) );
    boolean isAlive = true;
    String input;
    while ( isAlive ) {
      input = in.readLine();
      if ( (input != null) && (input.length() >= 1) ) {
        addClasses( new Integer( input ) );
      }
    }
  }

  private static void addClasses( int numberOfClassesToAdd )
  {
    int from = classesCounter;
    classesCounter += numberOfClassesToAdd;
    int to = classesCounter;
    IntStream.range( from, to ).forEach(
      i -> {
        try {
          classPool.makeClass("com.vatolinrp.gc.Generated" + i ).toClass();
        } catch (CannotCompileException e) {
          e.printStackTrace();
        }
      }
    );
  }
}
