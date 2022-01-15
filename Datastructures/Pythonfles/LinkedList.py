class Node:
    def __init__(self,data=None,next=None):
        self.data = data
        self.next = next
class Llist:
    def __init__(self):                 #1 Contructor
        self.length = 0
        self.first = None
        self.last = None
    def show(self):                     #2 prints th elements
        if(self.first == None):
            print("List is empty")
        else:
            temp = self.first
            while(temp!=self.last):
                print(temp.data,end="->")
                temp = temp.next
            print(self.last.data)
    def addFirst(self,item):            #3 Adds new element at first position
        if str(type(item))=="<class 'list'>":
            for i in item[::-1]:
                self.addFirst(i)
        else:
            if(self.first == None):
                self.length += 1
                node = Node(item,None)
                self.first = node
                self.last = node
            else:
                self.length += 1
                node = Node(item)
                node.next = self.first
                self.first = node
    def addLast(self,item):             #4 Adds element at last position
        if str(type(item))=="<class 'list'>":
            for i in item:
                self.addLast(i)
        else:
            node = Node(item)
            if(self.first==None):
                self.length += 1
                self.addFirst(item)
            elif(self.first==self.last):
                self.length += 1
                self.first.next = node
                self.last = node
            else:
                self.length += 1
                self.last.next = node
                self.last = node
    def indexOf(self,item):             #5 Returns the index of given eliment, returns -1 if element isn't found
        temp = self.first
        for i in range(self.length):
            if temp.data == item:
                return i
            temp = temp.next
        return -1
    def contains(self,item):            #6 Checks the eliment presence in list and returns boolean value
        temp = self.first
        for i in range(self.length):
            if temp.data == item:
                return True
            temp = temp.next
        return False
    def itemAt(self,index):             #7 returns item at given index
        if(index >= self.length):
            raise ValueError("Index out of range")
        else:
            temp = self.first
            for i in range(self.length):
                if(i==index):
                    return temp.data
                temp = temp.next
    def removeFirst(self):              #8 Removes first item from list
        if(self.first!=None):
            self.length -=1
            self.first = self.first.next
    def removeLast(self):               #9 Removes last item from list
        if(self.first!=None):
            if(self.first == self.last):
                self.removeFirst()
            else:
                self.length -=1
                temp = self.first
                for i in range(1,self.length):
                    temp = temp.next
                self.last = temp
    def removeAt(self,index):           #10 Removes item at given index
        if(index<self.length):
            if(index==0):
                self.removeFirst()
            elif(index==self.length-1):
                self.removeLast()
            else:
                temp1 = self.first
                temp2 = temp1.next
                for i in range(1,index):
                    temp1 = temp1.next
                    temp2 = temp1.next
                temp1.next = temp2.next
                self.length-=1
        else:
            raise ValueError("Index out of range.")
    def insert(self,index,item):        #11 Inserts new item at given index
        if index==0:
            self.addFirst(item)
        elif index==self.length:
            self.addLast(item)
        elif index in range(1,self.length):
            node = Node(item)
            temp = self.first
            for i in range(1,index):
                temp = temp.next
            node.next = temp.next
            temp.next = node
            self.length += 1
        else:
            raise ValueError("Index out of range")
    def countOf(self,item):             #12 Return the count of given item
        j=0
        temp = self.first
        for i in range(self.length):
            j += (1 if temp.data == item else 0)
            temp = temp.next
        return j
    def insertAfter(self,item_in_list,item_tobe_inserted): #13 Inserts item after a specified item
        if(item_in_list == self.first.data):
            self.insert(1,item_tobe_inserted)
        else:
            temp = self.first
            for i in range(self.length):
                if temp.data == item_in_list:
                    break
                temp = temp.next
            if(item_in_list == self.last.data and i==self.length-1):
                self.addLast(item_tobe_inserted)
            elif(temp.data == item_in_list):
                temp2 = temp.next
                node = Node(item_tobe_inserted)
                node.next = temp2
                temp.next = node
                self.length += 1
            else:
                print("Item not found.")
    def remove(self,item):              #14 Removes given item from list
        if self.first.data==item:
            self.removeFirst()
        elif(self.first.next==self.last and self.last.data == item):
            self.removeLast()
        else:
            temp = self.first
            while(temp.next.next!=self.last):
                if (temp.next.data==item):
                    break
                temp = temp.next
            if(temp.next == self.last and self.last.data==item):
                self.removeLast()
            elif(temp.next.data==item):
                temp2 = temp.next
                temp.next = temp2.next
                self.length -= 1
            else:
                print("Item not found.")



