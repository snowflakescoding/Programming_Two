package tutorials;

public class MaxFinding {

    public static int findMax(int arr[]) {
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] numbers = {3, 7, 2, 9, 1, 5};
        System.out.println("Maximum value: " + findMax(numbers));
    }
}

/*
Five Similarities Across All Three Versions:
1. Same Algorithm Logic: All three use the same approach - initialize max with first element, iterate through remaining elements, update max when larger value found
2. Sequential Control Flow: All follow the same execution order: initialization → loop → comparison → conditional update → return
3. Variable Purpose: Each version has a variable to track the current maximum value (max, max_val)
4. Conditional Statement: All use an if statement to compare current element with maximum
5. Return Statement: All return the maximum value at the end using a return statement

Three Key Differences:
Difference 1: Array Length Specification
- C: Requires explicit length parameter int n passed separately
- Java: Uses built-in arr.length property
- Python: No explicit length needed, can iterate directly over collection

Difference 2: Loop Syntax
- C: Traditional index-based for loop: for (int i = 1; i < n; i++)
- Java: Traditional index-based for loop: for (int i = 1; i < arr.length; i++)
- Python: Pythonic iteration with slicing: for num in arr[1:] (no manual indexing)

Difference 3: Type Declaration
- C: Explicit type declarations required: int arr[], int n, int max
- Java: Explicit type declarations required: int[] arr, int max
- Python: Dynamic typing, no type declarations: def find_max(arr), max_val = arr[0]

Why "Once You Master One Imperative Language, It's Easy to Learn Another"?
The lecture makes this statement because imperative languages share fundamental concepts:
1. Core Shared Concepts:

Same Mental Model: All imperative languages execute instructions sequentially, use variables to store state, and modify that state step-by-step
Universal Control Structures:
Loops (for, while)
Conditionals (if-else)
Functions/methods
Return statements
These work conceptually the same way across languages
Common Problem-Solving Approach: The algorithm design is language-independent. Once you understand HOW to solve a problem (the algorithm), you just need to learn the syntax differences
Transferable Logic: The thinking process is identical:
"I need to track a maximum value"
"I need to iterate through elements"
"I need to compare and conditionally update"
This logic translates directly between languages
Syntax is Surface-Level: The differences are mostly cosmetic:
Semicolons vs no semicolons
Curly braces vs indentation
Type declarations vs dynamic typing
arr.length vs len(arr) vs passing n

2. The Real Skill:

The hard part is learning algorithmic thinking and problem decomposition. Once you can think through a problem logically in one imperative language, you've already developed the critical skill. Learning another language is just learning new vocabulary to express the same ideas you already understand.

3. Analogy:
It's like learning to drive: once you know how to drive one car (steering, braking, accelerating), learning to drive another car is just about adjusting to slightly different pedal positions and dashboard layouts. The fundamental skill of driving transfers completely.
*/
