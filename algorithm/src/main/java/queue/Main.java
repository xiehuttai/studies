package queue;

public class Main {


    public static void main(String[] args) {
        Patient p1=new Patient("John",2);
        Patient p2=new Patient("Tom",9);
        Patient p3=new Patient("Jack",4);
        Patient p4=new Patient("Michael",6);

        PriorityQueue<Patient> priorityQueue=new PriorityQueue<>();
        priorityQueue.enqueue(p1);
        priorityQueue.enqueue(p2);
        priorityQueue.enqueue(p3);
        priorityQueue.enqueue(p4);

        while(priorityQueue.getSize()>0){
            System.out.print(priorityQueue.dequeue()+"  ");
        }
    }
    static class Patient implements Comparable{
        private String name;
        private int priority;
        public Patient(String name,int priority){
            this.name=name;
            this.priority=priority;
        }
        public String toString(){
            return name+"(priority:"+priority+")";
        }
        @Override
        public int compareTo(Object oo) {//比较优先级
            // TODO Auto-generated method stub
            return this.priority-((Patient)oo).priority;
        }


    }

}
