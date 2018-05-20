using System;

namespace p11_Convert_Speed_Units
{
    class ConvertSpeedUnits
    {
        static void Main(string[] args)
        {
            float distance = float.Parse(Console.ReadLine());
            float hours = float.Parse(Console.ReadLine());
            float minutes = float.Parse(Console.ReadLine());
            float seconds = float.Parse(Console.ReadLine());

            float totalSeconds = seconds + minutes * 60 + hours * 3600;
            float totalMinutes = totalSeconds / 60;
            float totalHours = totalMinutes / 60;

            Console.WriteLine(distance/totalSeconds);
            Console.WriteLine((distance/1000)/totalHours);
            Console.WriteLine((distance/1609)/totalHours);
        }
    }
}
