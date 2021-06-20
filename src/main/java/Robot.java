/*

Since this exercise has a difficulty of > 4 it doesn't come
with any starter implementation.
This is so that you get to practice creating classes and methods
which is an important part of programming in Java.

Please remove this comment when submitting your solution.

*/


import java.util.HashMap;
import java.util.Random;

public class Robot
{
    public static HashMap<String, Integer> names = new HashMap<>();

    private String name;


    public String getName()
    {
        boolean isDifferentName = false;
        String answer = "";

        while (!isDifferentName)
        {
            answer = getSomeName();
            Integer nameValue = names.putIfAbsent(answer, 1);

            if (nameValue == null) //Already has same name
            {
                isDifferentName = true;
            }
        }
        this.name = answer;

        return answer;
    }

    private String getSomeName()
    {
        String answer = "";
        Letters letterCluster = new Letters();
        Digits digitsCluster = new Digits();
        String someLetters = letterCluster.createClusterOfCharacters(2);
        String someDigits = digitsCluster.createClusterOfCharacters(3);

        answer = someLetters.concat(someDigits);
        return answer;
    }

    public void reset()
    {
        this.name = "";
        names.remove(this.name);
            
    }

}

class RobotTesters
{
    public static void main(String meow[])
    {
        /*Robot rob1 = new Robot();
        rob1.getName();
        Robot rob2 = new Robot();
        rob2.getName();
        */
        Digits aDigits = new Digits();
        String someDigitCluster = aDigits.createClusterOfCharacters(5);
    }
}

abstract class Characters
{
    Random aRan = new Random();

    abstract public String createCharacter();

    public String createClusterOfCharacters(int amount)
    {
        String answer = "";
        for (int i = 0; i < amount; i++)
        {
            answer = answer.concat(createCharacter());
        }
        return answer;
    }
}

class Digits extends Characters
{

    @Override
    public String createCharacter()
    {
        char aDigit = (char) (aRan.nextInt(9) + 48);
        return Character.toString(aDigit);
    }

}

class Letters extends Characters
{
    @Override
    public String createCharacter()
    {
        char aLetter = (char) (aRan.nextInt(25) + 65);
        return Character.toString(aLetter);
    }
}