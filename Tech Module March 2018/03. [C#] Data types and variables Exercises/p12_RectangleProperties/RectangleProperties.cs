using System;

namespace p12_RectangleProperties
{
    class RectangleProperties
    {
        static void Main(string[] args)
        {
            double sideA = double.Parse(Console.ReadLine());
            double sideB = double.Parse(Console.ReadLine());

            double perimeter = 2 * sideA + 2 * sideB;
            double area = sideB * sideA;
            double diagonal = Math.Sqrt(Math.Pow(sideA,2) + Math.Pow(sideB,2));

            Console.WriteLine(perimeter);
            Console.WriteLine(area);
            Console.WriteLine(diagonal);
        }
    }
}
