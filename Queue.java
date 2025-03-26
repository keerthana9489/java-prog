public class Queue {
 int SIZE=5;
 int items[]=new int[SIZE];
 int front,rear;
 Queue() {
  front=-1;
  rear=-1;

}
//check if the queue is full
boolean isFull() {
 if(front==0&&rear==size-1){
  return true;

}

  return false;

}
//check if the queue is empty
boolean isEmpty(){
 if(front==-1)
  return true;
 else
  return false;

}
//insert element to the queue
void enQueue(int element){
//if queue is full
if(isFull()) {
 System.out.println("Queue is full");

}

else {

 if(front==-1) {
  //mark front denote first element of queue
  front=0;     }

rear++; 

  //insert element at the rear
  items[rear]=element;
    System.out.println("insert"+element);

   }
  
  } 
  
  //delete element from the queue
  int deQueue() {
   int element;
   //if queue is empty
   if(isEmpty()) {
    System.out.println("Queue is empty");
    return(-1);
 
  }

  else {
  //remove element from the front of queue
  element=items[front];
  //if the queue has only one element
  if(front>=rear) {
   front=-1;
   rear=-1;

  }

  else{
  //mark next element as the front
   front ++;
  }
  
  System.out.println(element + deleted);
  return(element); }

} 

  //dlsplay element of the queue
  void display () {
   int i ;
   if(isEmpty()) {
    System.out.println("Empty Queue"); }
 
   else {

     //display the front of the queue
     System.out.println("\n Frontindex->"+rear);
     
     //display element of the queue
     System.out.print("Items->");
     for(i=front; i<=rear; i++ )

     System.out.print(items[i]+" ");
     
     //display the rear of the queue
     
     System.out.println("\nRear intex->"+rear);
     }
   }
   
   public static void main(String[]args) {
   //create an object of Queue() class
   Queue q=new Queue();
   
   q.deQueue();

   for (int i=1; i<6 ; i++) {
          q.enQueue(i);

          }
             
          q.enQueue(6);
          q.display();
          q.deQueue();
          q.display();
          }

}


         
   
   
     