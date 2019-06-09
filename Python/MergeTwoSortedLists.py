from collections import deque

class ListNode:
    def __init__(self, data):
        # Constructor class that initiates the object

        # Stores the data
        self.data = data

        # Store Reference (Next Item)
        self.next = None

        # Store Reference (Previous Item)
        self.previous = None

        return

class DoubleLinkedList:
    def __init__(self):
        # Constructor to initiate this object

        # The memory location of the head node
        self.head = None
        # The memory location of the node trailing the head node
        self.tail = None

        return

    def list_length(self):
        # Returns the number of list items

        # The 'count' variable keeps track of the number of elements 
        # within the Double Linked List
        count = 0
        # The current node is the pointer that tracks the memory location of the node 
        # that is currently being viewed.
        current_node = self.head

        # While-loop that counts the number of elements 
        # and traverses the Double Linked List.
        while current_node is not None:
            # Increase Counter by One
            count = count + 1

            # Jump to the Linked Node
            current_node = current_node.next
        
        return count

    def output_list(self):
        # Outputs the list ( the value of the node, actually )

        # The current node is the pointer that tracks the memory location of the node 
        # that is currently being viewed.
        current_node = self.head

        # While-loop that prints the data of the nodes 
        # that are within the Double Linked List.
        while current_node is not None:
            # Prints the data of the current node
            print str(current_node.data)

            # Jump to the Linked Node
            current_node = current_node.next

        return

    def unordered_search(self, value):

        current_node = self.head
        node_id = 1

        results = []



    def add_list_item(self, item):
        # Add an item at the end of the list
        
        # Checks the item to verify that it is in the instance of a 'ListNode' object.
        if not isinstance(item, ListNode):
            # If the item is not a 'ListNode' object, 
            # then the item is transformed into a 'ListNode'.
            item = ListNode(item)

        # If the list is Empty..
        if self.head is None:  
            # The element is added as the head node..
            self.head = item
            item.previous = None
            item.next = None
            self.tail = item
        # If the list is not empty..
        else:
            # The element is added as a trail node..
            self.tail.next = item
            item.previous = self.tail
            self.tail = item

        return

    def mergeList(self, list1, list2):

        list1node = list1.head
        list2node = list2.head

        while (list1node is not None and list1node.next is not None) or (list2node is not None and list2node.next is not None):
            if list1node.data < list2node.data:
                self.add_list_item(list1node.data)
                list1node = list1node.next
            else:
                self.add_list_item(list2node.data)
                list2node = list2node.next

        if list1node.data < list2node.data:
            self.add_list_item(list1node.data)
            list1node = list1node.next
        else:
            self.add_list_item(list2node.data)
            list2node = list2node.next

        if list1node is not None:
            while list1node is not None:
                self.add_list_item(list1node.data)
                list1node = list1node.next
        
        if list2node is not None:
            while list2node is not None:
                self.add_list_item(list2node.data)
                list2node = list2node.next
        
        self.output_list()

        return

node1 = ListNode(15)
node2 = ListNode(8.2)
item3 = "Berlin"
node4 = ListNode(15)

track = DoubleLinkedList()
print "Track Length: %i" % track.list_length()

for current_node in [node1, node2, item3, node4]:
    track.add_list_item(current_node)
    print "Track Length: %i" % track.list_length()
    track.output_list()

print "\n"

track = DoubleLinkedList()

node1 = ListNode(1)
node2 = ListNode(2)
node3 = ListNode(4)

for current_node in [node1, node2, node3]:
    track.add_list_item(current_node)
    track.output_list()

track2 = DoubleLinkedList()

node4 = ListNode(1)
node5 = ListNode(3)
node6 = ListNode(4)

for current_node in [node4, node5, node6]:
    track2.add_list_item(current_node)
    track2.output_list()

newlist = DoubleLinkedList()

print "\n"

newlist.mergeList(track, track2)