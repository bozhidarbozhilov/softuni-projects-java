using System;

namespace p16_ComparingFloats
{
    class ComparingFloats
    {
        static void Main(string[] args)
        {
            double firstDouble = double.Parse(Console.ReadLine());
            double secondDouble = double.Parse(Console.ReadLine());
            double eps = 0.000001;
            bool isEqual = false;

            if(Math.Abs(firstDouble - secondDouble) < eps)
            {
                isEqual = true;
            }
            Console.WriteLine(isEqual);
        }
    }
}
