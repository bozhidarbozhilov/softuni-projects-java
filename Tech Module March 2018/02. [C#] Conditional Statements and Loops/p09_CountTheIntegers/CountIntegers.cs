using System;

namespace p09_CountTheIntegers
{
    class CountIntegers
    {
        static void Main(string[] args)
        {
            int counter = 0;
            int num = 0;
            while (int.TryParse(Console.ReadLine(), out num))
            {
                counter++;
            }
            Console.WriteLine(counter);
        }
    }
}
