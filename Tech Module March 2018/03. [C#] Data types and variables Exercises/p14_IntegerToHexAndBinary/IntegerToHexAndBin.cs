using System;

namespace p14_IntegerToHexAndBinary
{
    class IntegerToHexAndBin
    {
        static void Main(string[] args)
        {
            int decNum = int.Parse(Console.ReadLine());

            string hexNum = Convert.ToString(decNum, 16).ToUpper();
            string binNum = Convert.ToString(decNum, 2);

            Console.WriteLine(hexNum);
            Console.WriteLine(binNum);
        }
    }
}
