using System;
using System.Text;
using System.Linq;


public class Test
{
	public static void Main()
	{
		Console.ReadLine();
		int[] compare = Read_ints();
		int inputCnt = Convert.ToInt32(Console.ReadLine());
		int[] input = Read_ints();
		bool[] isExist = new bool[inputCnt];
		StringBuilder sb = new StringBuilder();

		//// 어 저도 처음에 이렇게 했더니 시간초과 나던데.. 채점기록 보니까 여러번 시간초과 후에 성공하신거 같은데 시간을 단축한 비결이 있나요? : 22 저도 궁금합니다
		//// 처음에는 string으로 해서 비교했다가 검색해보니 string으로 찾는게 더 시간이 오래 걸린다 해서 int로 바꿔줬더니 성공했어요!
		for (int i = 0; i < inputCnt; i++)
		{
			if (compare.Contains(input[i]))
				isExist[i] = true;

			sb.Append(Convert.ToInt32(isExist[i]) + "\n");
		}
		Console.Write(sb);
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
