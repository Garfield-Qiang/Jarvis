package algorithms.medium;

/**
 * 给定一个数组，将数组的值作为y，索引之差作为x，求出最大的x*y。
 * @author Jarvis
 *
 */
public class ContainerWithMostWater {
	
	public int maxArea(int[] height) {
		int max = 0;
		for(int i = 0;i<height.length-1;i++) {
			for(int j = i+1 ;j<height.length;j++) {
				int temp = height[j] > height[i] ? height[i]:height[j];
				max = max > temp*(j-i) ? max :  temp*(j-i) ;
			}
		}
        return max;
    }
	
	public static void main(String[] args) {
		ContainerWithMostWater clazz = new ContainerWithMostWater();
		int[] height = {1,8,6,2,5,4,8,3,7};
		System.out.println(clazz.maxArea(height));
	}
}
