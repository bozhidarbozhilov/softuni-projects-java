using System;

namespace p15_PrimeCheckerRefactor
{
    class PrimeChecker
    {
        static void Main(string[] args)
        {
            int number = int.Parse(Console.ReadLine());

            for (int numToCheck = 2; numToCheck <= number; numToCheck++)
            {
                bool isPrime = true;
                for (int divisor = 2; divisor <= Math.Sqrt(numToCheck); divisor++)
                {
                    if (numToCheck % divisor == 0)
                    {
                        isPrime = false;
                        break;
                    }
                }
                Console.WriteLine($"{numToCheck} -> {isPrime}");
            }

        }
    }
}
