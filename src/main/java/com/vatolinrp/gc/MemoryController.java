package com.vatolinrp.gc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MemoryController
{
  public static void main( String[] args )
    throws Exception
  {
    BufferedReader in = new BufferedReader( new InputStreamReader( System.in ) );
    List objects = new ArrayList();
    boolean isAlive = true;
    String input;
    while ( isAlive ) {
      System.out.println( "objects take :" + objects.size() * 50 + "MB" );
      System.out.println( "Add or subtract objects: 1 takes 50 MB" );
      input = in.readLine();
      if ((input != null) && (input.length() >= 1) ) {
        char operation = input.charAt( 0 );
        int numberOfObjects = new Integer( input.substring(1, input.length() ) );
        switch ( operation ) {
          case '+': {
            addObjects( objects, numberOfObjects );
            break;
          }
          case '-': {
            removeObjects( objects, numberOfObjects );
            break;
          }
        }
      }
    }
  }

  private static void removeObjects(List objects, Integer integer)
  {
    while( integer > 0 ) {
      objects.remove(0 );
      integer--;
    }
  }

  private static void addObjects(List objects, Integer integer)
  {
    while( integer > 0 ) {
      objects.add( new byte[50*1024*1024] );
      integer--;
    }
  }

}
