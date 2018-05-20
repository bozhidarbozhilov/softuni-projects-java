using System;

namespace p13_GameOfNumbers
{
    class GameOfNumbers
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int m = int.Parse(Console.ReadLine());
            int magicalNumber = int.Parse(Console.ReadLine());

            bool isEqualOrGreater = false;
            int counter = 0;
            int a = 0;
            int b = 0;

            for (int i = n; i <= m; i++)
            {
                for (int j = n; j <= m; j++)
                {
                    a = i;
                    b = j;
                    counter++;   
                    if (i + j == magicalNumber)
                    {
                        isEqualOrGreater = true;
                        break;
                    }
                }
                if (isEqualOrGreater)
                {
                    break;
                }
            }
            if (isEqualOrGreater)
            {
                Console.WriteLine($"Number found! {b} + {a} = {magicalNumber}");
            }
            else
            {
                Console.WriteLine($"{counter} combinations - neither equals {magicalNumber}");
            }
        }
    }
}
