class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None
        
        return

class Solution:
    def __init__(self):
        self.head = None
        self.tail = None

        return

    def add(self, item):
        if not isinstance(item, ListNode):
            item = ListNode(item)

        if self.head is None:
            self.head = item
        else:
            self.tail.next = item

        self.tail = item

        return

    def list_length(self):
        "Returns the number of list items"

        count = 0
        current_node = self.head

        while current_node is not None:
            # Increase counter by one
            count = count + 1

            # Jump to the linked node
            current_node = current_node.next

        return count

    def output_list(self):
        current_node = self.head

        while current_node is not None:
            print str(current_node.val)

            current_node = current_node.next
        
        return

    def mergeTwoLists(self, l1, l2):
        list1node = l1.head
        list2node = l2.head

        l1.output_list()
        l2.output_list()

        print "\n"

        while list1node is not None:
            print str(list1node.val)

            list1node = list1node.next

        while list2node is not None:
            print str(list2node.val)

            list2node = list2node.next

        list1node = l1.head
        list2node = l2.head

        list1nodeLength = l1.list_length()
        list2nodeLength = l2.list_length()

        print "List 1 Length: " + str(list1nodeLength)

        print "List 2 Length: " + str(list2nodeLength)

        if list1nodeLength < list2nodeLength:
            loopLength = list1nodeLength
        else:
            loopLength = list2nodeLength
            
        while list1node is not None:
            if list1node.val < list2node.val:
                print "List 1 value is less than list 2 value at specific point.."
            else:
                print "List 2 value is less than list 1 value at specific point.."

            list1node = list1node.next

        return

track = Solution()

node1 = 1
node2 = 2
node3 = 4

for current_node in [node1, node2, node3]:
    track.add(current_node)

track2 = Solution()

node4 = 1
node5 = 3
node6 = 4

for current_node in [node4, node5, node6]:
    track2.add(current_node)

#track.output_list()

print "\n"

#track2.output_list()

newlist = Solution()

newlist.mergeTwoLists(track, track2)

print "\n"

newlist.output_list()