using System;

namespace p10_Centuries_to_miliseconds
{
    class CenturiesToMsecs
    {
        static void Main(string[] args)
        {
            byte century = byte.Parse(Console.ReadLine());
            ushort years = (ushort)(century *100);
            int days = (int)(years * 365.2422);
            uint hours = (uint)(days * 24);
            long minutes = (long)(hours * 60);
            long seconds = minutes * 60;
            ulong miliseconds = (ulong)(seconds * 1000);
            decimal microseconds = miliseconds * 1000;
            decimal nanoseconds = microseconds * 1000;

            Console.WriteLine($"{century} centuries = {years} years = {days} days " +
                $"= {hours} hours = {minutes} minutes = {seconds} seconds " +
                $"= {miliseconds} milliseconds = {microseconds} microseconds" +
                $" = {nanoseconds} nanoseconds");

        }
    }
}
