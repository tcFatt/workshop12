package visa.w2;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class NumbersService {

    public Set<Integer> generateRandomNumbers(Numbers number) {
        // set the range for the number key in
        int min = 0;
        int max = 30;
        // create Random object for getting random number
        Random randNum = new Random();
        // create an int equally to number submitted
        int numberSubmit = number.getNumber();
        // create LinkedHashSet to store unique numbers
        Set<Integer> setNumbers = new LinkedHashSet<Integer>();
        // generate random number and store in the Set
        while(setNumbers.size() < numberSubmit) {
            setNumbers.add(randNum.nextInt(max - min) + min); 
        }
        System.out.println(">>> setNumbers: " + setNumbers);
        return setNumbers;
    }
}
