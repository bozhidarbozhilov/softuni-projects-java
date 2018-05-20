using System;

namespace p15_Neighbour_Wars
{
    class Program
    {
        static void Main(string[] args)
        {
            int peshoHealth = 100;
            int goshoHealth = 100;
            int rounds = 1;

            int peshoDamage = int.Parse(Console.ReadLine());
            int goshoDamage = int.Parse(Console.ReadLine());

            while(true)
            {
                if(rounds%2 != 0)
                {
                    goshoHealth -= peshoDamage;
                    if (goshoHealth > 0)
                    {
                        Console.WriteLine($"Pesho used Roundhouse kick and reduced Gosho to {goshoHealth} health.");
                    }
                    else
                    {
                        Console.WriteLine($"Pesho won in {rounds}th round.");
                        break;
                    }
                }
                else 
                {
                    peshoHealth -= goshoDamage;
                    if (peshoHealth > 0)
                    {
                        
                        Console.WriteLine($"Gosho used Thunderous fist and reduced Pesho to {peshoHealth} health.");

                    }
                    else
                    {
                        Console.WriteLine($"Gosho won in {rounds}th round.");
                        break;
                    }
                }

                if(rounds%3 == 0)
                {
                    peshoHealth += 10;
                    goshoHealth += 10;
                }
                rounds++;
            }

        }
    }
}
