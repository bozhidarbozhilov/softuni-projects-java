using System;

namespace p06_IntervalOfNumbers
{
    class IntervalOfNumbres
    {
        static void Main(string[] args)
        {
            int firstNum = int.Parse(Console.ReadLine());
            int secondNum = int.Parse(Console.ReadLine());

            if (secondNum > firstNum)
            {
                for (int i = firstNum; i <= secondNum; i++)
                {
                    Console.WriteLine(i);
                }
            }
            else
            {
                for (int i = secondNum; i <= firstNum; i++)
                {
                    Console.WriteLine(i);
                }
            }

        }
    }
}
