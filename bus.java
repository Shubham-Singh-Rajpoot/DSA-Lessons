/*Write a program for the Bus registration system which accepts the seat which the customer want to book and also shows the arrangement of seats
   in the bus. Repeat the same process multiple times,and show various relevant messages if the customer makes the wrong choice or want to book a
   seat which does not exists*/
   import java.util.*;
   class Bus
   {
       static int bus[][]=new  int[10][5];
       static int booked[]=new  int[50];
       public static void main(String[] args)
       {
           Scanner sc=new  Scanner(System.in);
           int k=1,i,j;
           booked();
           boolean avaliability=false;
          for(i=0;i<10;i++)
          {
             for(j=0;j<5;j++)
             {
                bus[i][j]=k;
                k++;
             }
          }
          k=0;
          Differenciate();
          System.out.println("Welcome to Red Bus");
              Differenciate();
               while(true)
           {
              System.out.println("The Seats availiable in our bus are as follows:");
              Seat_Arrangement();
              Differenciate();
              System.out.println("NOTE: The seats having number \"0\" are already booked");
              System.out.println("Enter the number of the seat you want to book");
              j=sc.nextInt();
              Differenciate();
              if(j<1||j>50)
              {
               System.out.println("This seat does not Exist....Please Enter a valid seat number");
               Differenciate();
               continue;
               }
               avaliability=booked(j);
              if(avaliability==true)
              {
                 System.out.println("The seat is already Booked.....Please try booking another seat");
               }
                 else
              {
                 System.out.println("Booking Confirmed");
                 booked[k]=j;
                 k++;
               }
               Differenciate();
               System.out.println("Do you want to book more seats");
               System.out.println("Enter you choice");
               System.out.println("1 for Yes,0. for No");
               int choice=sc.nextInt();
               Differenciate();
               if(choice==0)
               {
                   System.out.println("Thank You for using Red Bus");
                   System.out.println("The seats you booked were:");
                   int r;
                   for(r=0;r<50;r++)
                   {
                       if(booked[r]!=0)
                       System.out.println(booked[r]);
                   }
                   Differenciate();
                   break;
               }
               else if(choice==1)
                 continue;
              else
                 System.out.println("Invalid Choice...Please enter a Valid Choice");
          }
       }
       public static void Seat_Arrangement()
       {
           int i,j;
           for(i=0;i<10;i++)
           {
               for(j=0;j<5;j++)
               {
                   boolean flag=false;
                   flag=booked(bus[i][j]);
                   if(flag==false)
                   {
                      if(j!=1)
                         System.out.print(" ["+bus[i][j]+"]\t");
                      else if(j==1)
                         System.out.print(" ["+bus[i][j]+"]\t\t");
                       }
                   else if(flag==true)
                   {
                       if(j!=1)
                          System.out.print(" ["+0+"]\t");
                       else if(j==1)
                          System.out.print(" ["+0+"]\t\t");
                   }
                   }
               System.out.println();
           }
       }
       public static void Differenciate()
       {
           int i;
           for(i=0;i<300;i++)
              System.out.print("-");
              System.out.println();
       }
       public static void booked()
       {
           int n;
           for(n=0;n<50;n++)
           {
               booked[n]=0;
           }
       }
       public static boolean booked(int n)
       {
           int i;
           for(i=0;i<50;i++)
           {
              if(booked[i]==n)
              return true;
           }
           return false;
       }
   }