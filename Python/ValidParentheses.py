class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool

        This method uses two containers to implement the functions purpose:
            stack = [] : The stack object
            s[i] : The character array

        Traverses the character array and adds the opening parts of the brackets, braces, and parentheses
        to the stack.
        Once all of the opening parts have been added, it checks the ending parts of the brackets, braces, and parentheses
        against the top element of the stack.

        If the top element is the corresponding element to the ending piece of the bracket, brace, or parenthesis
        then the top element is popped or removed from the stack.
        If the top element is not the corresponding element to the ending piece of the bracket, brace, or parenthesis
        then the method returns false and terminates.

        In order to receive a true statement for an input string,
        the stack must be empty.
        If the method reaches the end and the stack is not empty,
        it means the stack is unbalanced and therefore false.
        """
        stack = []
        
        print s
        for i in range(len(s)):
            print str(i) + " in range of the length of string s..."

            if s[i] == '(' or s[i] == '[' or s[i] == '{':
                print s[i] + " is being appended to the stack..."
                stack.append(s[i])
                
            if s[i] == '}':
                print s[i] + " is equal to '}'..."
                
                print stack

                '''
                Even though the stack.pop() was executed within an if-statement,
                the stack method still operates, whether the statement is true or false
                
                There is no need for concern with the rest of the stack
                because the method terminates when this condition is not met.
                The rest of the stack will not be accessed after termination.
                '''

                if stack == [] or stack.pop() != '{':
                    print "The stack is either empty or the top element is not equal to '{'..."
                    return False

                print "The top element is equal to '{' and has been removed from the stack..."
                print stack
            if s[i] == ')':
                print s[i] + " is equal to ')'..."

                print stack
                if stack == [] or stack.pop() != '(':
                    print "The stack is either empty or the top element is not equal to '('..."
                    return False

                print "The top element is equal to '(' and has been removed from the stack..."
                print stack
            if s[i] == ']':
                print s[i] + " is equal to ']'..."

                print stack
                if stack == [] or stack.pop() != '[':
                    print "The stack is either empty or the top element is not equal to '['..."
                    return False
        
                print "The top element is equal to '[' and has been removed from the stack..."
                print stack

            print "\n"

        if stack:
            print "The stack is not empty..."
            return False
        else:
            print "The stack is empty..."
            return True
    
verify = Solution()

isValid = verify.isValid("({[]})")
print isValid

print "\n"

isValid = verify.isValid("(]")
print isValid

print "\n"

isValid = verify.isValid("([)]")
print isValid

print "\n"

isValid = verify.isValid("")
print isValid

print "\n"

#isValid = 747645636373
#print isValid

#print (isinstance(isValid, str))

#print "\n"

#stringlist = list("({[]})")
#print stringlist
#print "Length of list of characters in string: " + str(len(stringlist))

isValid = verify.isValid("(")
print isValid

print "\n"

isValid = verify.isValid("[([]])")
print isValid

print "\n"

isValid = verify.isValid("()")
print isValid