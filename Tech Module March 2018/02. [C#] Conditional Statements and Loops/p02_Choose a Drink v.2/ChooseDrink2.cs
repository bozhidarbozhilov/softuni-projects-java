using System;

namespace p02_Choose_a_Drink_v._2
{
    class ChooseDrink2
    {
        static void Main(string[] args)
        {
            string proffesion = Console.ReadLine();
            int quantity = int.Parse(Console.ReadLine());

            switch (proffesion)
            {
                case "Athlete":
                    Console.WriteLine($"The {proffesion} has to pay {quantity*0.7:F2}.");
                    break;
                case "Businessman":
                case "Businesswoman":
                    Console.WriteLine($"The {proffesion} has to pay {quantity * 1.0:F2}.");
                    break;
                case "SoftUni Student":
                    Console.WriteLine($"The {proffesion} has to pay {quantity * 1.7:F2}.");
                    break;
                default:
                    Console.WriteLine($"The {proffesion} has to pay {quantity * 1.2:F2}.");
                    break;
            }
        }
    }
}
