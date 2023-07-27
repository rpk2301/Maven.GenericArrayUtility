package com.zipcodewilmington.arrayutility;




import java.lang.reflect.Array;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T>
{

    private T[]inputArray;

    public ArrayUtility(T[]inputArray)
    {
    this.inputArray = inputArray;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate)
    {
        Integer counter = 0;
        int loop=0;
        T[] ret = (T[]) Array.newInstance(valueToEvaluate.getClass(), inputArray.length + arrayToMerge.length);
        for (int i = 0; i < inputArray.length; i++)
        {
            ret[i] = inputArray[i];
        }
        for (int i = inputArray.length; i < ret.length; i++)
        {
            ret[i] = arrayToMerge[loop];
            loop++;
        }

        for (T t : ret) {
            if (t.equals(valueToEvaluate)) {
                counter++;
            }
        }
        this.inputArray=ret;
        return counter;
    }
    
    
    public void Merge(T[] toMerge)
    {
        int loop=0;
        T[] ret = (T[]) Array.newInstance(toMerge.getClass().getComponentType(), inputArray.length + toMerge.length);
        for (int i = 0; i < inputArray.length; i++)
        {
            ret[i] = inputArray[i];
        }
        for (int i = inputArray.length; i < ret.length; i++)
        {
            ret[i] = toMerge[loop];
            loop++;
        }   
        this.inputArray=ret;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge)
    {
      Merge(arrayToMerge);
      int max=0;
      T object = null;

      for(T t: this.inputArray)
      {
          int count =0;
          for(T f:arrayToMerge)
          {
              if(t.equals(f))
              {
                 count++;
                 if(count>max)
                 {
                     max = count;
                     object = f;
                 }
              }
          }
      }
        return object;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        int counter = 0;

        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] == valueToEvaluate) {
                counter++;
            }

        }
        return counter;
    }
    public T[] removeValue(T valueToRemove) {
        int counter=0;
      //  T[] ret = new T[];
        int sizeModifier = getNumberOfOccurrences(valueToRemove);
        T[] ret = (T[]) Array.newInstance(valueToRemove.getClass(),inputArray.length-sizeModifier);
        for(int i=0;i<inputArray.length;i++)
        {
            if(!inputArray[i].equals(valueToRemove))
            {
            ret[counter] = inputArray[i];
            counter++;
            }
        }
    return ret;
    }




}
