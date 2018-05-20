using System;

namespace p12_TestNumbers
{
    class TestNumbers
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int m = int.Parse(Console.ReadLine());
            int sum = int.Parse(Console.ReadLine());

            int counter = 0;
            int currentSum = 0;
            bool isGreater = false;

            for (int i = n; i > 0; i--)
            {
                for(int j = 1; j<=m; j++)
                {
                    currentSum += (i * j)*3;
                    counter++;
                    if(currentSum >= sum)
                    {
                        isGreater = true;
                        break;
                    }

                }
                if (currentSum >= sum)
                {
                    break;
                }
            }
            if (isGreater)
            {
                Console.WriteLine($"{counter} combinations");
                Console.WriteLine($"Sum: {currentSum} >= {sum}");
            }
            else
            {
                Console.WriteLine($"{counter} combinations");
                Console.WriteLine($"Sum: {currentSum}");
            }
        }
    }
}
