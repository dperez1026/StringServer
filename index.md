![Image](webs3.png)
>For the following code,
![Image](webs6.png)
>The method called is **handleRequest(Socket clientSocket)**, the relevant argument 'clientSocket' responds back to the client which is a reference to the client's socket, the request is a 'GET' request for the add-message path that has a query param called 's' which for this example would be 'Hello'. The field changes include 'message' being update to 'Hello' instead of being empty. 
>![Image](webs5.png) 
>For the next image, the same method **handleRequst(Socket clientSocket)** is being called, the relevent args are 'clientSocket' and the GET request adds the message with the same param 's' which is set to 'What are you doing later?'. The field 'message' now changes to 'What are you doing later?'. 
# invalid test
```public class ArrayTests {
	@Test 
	public void testReverseInPlace() {
    int[] input1 = {0,1,2,3,4};
    ArrayExamples.reverseInPlace(input1);
    assertArrayEquals(new int[]{4,3,2,1,0}, input1);
	}
```
the following code tests the code below and results in an error for this code:
```static void reverseInPlace(int[] arr) {
    for(int i = 0; i < arr.length; i += 1) {
      arr[i] = arr[arr.length - i - 1];
    }
  }
```
This input does **not** induce a failure for a different line of code.:
```@Test
  public void testReversed() {
    int[] input1 = { };
    assertArrayEquals(new int[]{ }, ArrayExamples.reversed(input1));
  }
}
```
for the code: 
```static int[] reversed(int[] arr) {
    int[] newArray = new int[arr.length];
    for(int i = 0; i < arr.length; i += 1) {
      arr[i] = newArray[arr.length - i - 1];
    }
    return arr;
  }
```
![Image](fail2.png) 
>for this code, the void keyword is causing the reverseinplace to not return anything, along with needed a temp value to save our initial value. 
```static void reverseInPlace(int[] arr) {
    for(int i = 0; i < arr.length; i += 1) {
      arr[i] = arr[arr.length - i - 1];
    }
  }
``` 
Here is the code before the bug is fixed, 

``` static int[] reverseInPlace(int[] arr) {
    for(int i = 0; i < arr.length; i += 1) {
      int temp=arr[i];
      arr[i] = arr[arr.length - i - 1];
      arr[arr.length-i-1]=temp;

    }
    return arr;
  }
```
This is what it looks like after it is fixed. 
>In lab week 3, I learned that in order to sucessfully create a new local host you need to have a port number that is unique, which means the number should usually be a very high-valued number. 



