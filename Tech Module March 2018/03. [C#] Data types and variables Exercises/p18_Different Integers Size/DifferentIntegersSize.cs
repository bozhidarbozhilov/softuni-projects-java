using System;

namespace p18_Different_Integers_Size
{
    class DifferentIntegersSize
    {
        static void Main(string[] args)
        {
            string inputStr = Console.ReadLine();
            if(long.TryParse(inputStr, out long inputNum))
            {
                Console.WriteLine($"{inputNum} can fit in:");
                if (inputNum>=sbyte.MinValue && inputNum <= sbyte.MaxValue)
                {
                    Console.WriteLine("* sbyte");
                }
                if (inputNum >= byte.MinValue && inputNum <= byte.MaxValue)
                {
                    Console.WriteLine("* byte");
                }
                if (inputNum >= short.MinValue && inputNum <= short.MaxValue)
                {
                    Console.WriteLine("* short");
                }
                if (inputNum >= ushort.MinValue && inputNum <= ushort.MaxValue)
                {
                    Console.WriteLine("* ushort");
                }
                if (inputNum >= int.MinValue && inputNum <= int.MaxValue)
                {
                    Console.WriteLine("* int");
                }
                if (inputNum >= uint.MinValue && inputNum <= uint.MaxValue)
                {
                    Console.WriteLine("* uint");
                }
                if (inputNum >= long.MinValue && inputNum <= long.MaxValue)
                {
                    Console.WriteLine("* long");
                }

            }
            else
            {
                Console.WriteLine($"{inputStr} can't fit in any type");
            }

        }
    }
}
