using System;

namespace p11_FiveDifferentNumbers
{
    class FiveDifferentNumbers
    {
        static void Main(string[] args)
        {
            int firstNum = int.Parse(Console.ReadLine());
            int secondNum = int.Parse(Console.ReadLine());

            if (secondNum - firstNum >= 5)
            {
                for (int a = firstNum; a <= secondNum; a++)
                {
                    for (int b = firstNum; b <= secondNum; b++)
                    {
                        for (int c = firstNum; c <= secondNum; c++)
                        {
                            for (int d = firstNum; d <= secondNum; d++)
                            {
                                for (int e = firstNum; e <= secondNum; e++)
                                {
                                    if (a < b && b < c && c < d && d < e)
                                    {
                                        Console.WriteLine(a + " " + b + " " + c + " " + d + " " + e);
                                    }
                        
                                }
                            }
                        }
                    }

                }
            }
            else
            {
                Console.WriteLine("No");
            }

        }
    }
}
