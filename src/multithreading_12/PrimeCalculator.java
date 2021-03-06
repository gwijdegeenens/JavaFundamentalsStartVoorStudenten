package multithreading_12;

import java.util.*;
import java.util.concurrent.*;

public class PrimeCalculator implements Callable<List<Long>> {
   private long max;
   
   public PrimeCalculator(long max) {
      this.max= max;
   }
     
   @Override
   public List<Long> call() throws Exception {
      List<Long> primes = new ArrayList<>();
      for (long number = 2; number <= max; number++) {
         boolean isPrime = true;         
         for (int i = 0; (i < primes.size()) && isPrime && ((primes.get(i)*primes.get(i)) <= number) ; i++) {
            isPrime = (number % primes.get(i)) != 0;
         }

         if (isPrime) {
            primes.add(number);
         }
      }
      return primes;
   }
   
}
