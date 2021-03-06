using System;

public class Test
{
	public static void Main()
	{
		int[] startTime = Read_ints();
		int startHour = startTime[0];
		int startMinute = startTime[1];

		int[] endTime = Read_ints();
		int endHour = endTime[0];
		int endMinute = endTime[1];

		string findMinute = Console.ReadLine();
		int cnt = 0;

		for (int i = startHour; i < endHour + 1; i++)
		{
			int start = (i == startHour) ? startMinute : 0;
			int end = (i == endHour) ? endMinute : 59;
			for (int j = start; j < end + 1; j++)
			{
				string iToCompare = i > 10 ? i.ToString() : "0" + i.ToString();
				string jToCompare = j > 10 ? j.ToString() : "0" + j.ToString();
				string compare = iToCompare + jToCompare;
				if (compare.IndexOf(findMinute) > -1) cnt++;
			}
		}
		Console.Write(cnt);
	}

	static int[] Read_ints()
	{
		string input = Console.ReadLine();
		string[] strArr = input.Split(' ');
		int len = strArr.Length;
		int[] nums = new int[len];
		for (int i = 0; i < len; i++)
			nums[i] = Convert.ToInt32(strArr[i]);
		return nums;
	}
}