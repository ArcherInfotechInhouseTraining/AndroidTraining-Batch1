from tkinter import*
from tkinter import ttk
from PIL import Image,ImageTk #imprt Background Image pip install pillow
import PIL.Image
from tkinter import messagebox
# import pandas as pd


class login_window:
    def __init__(self,root):
        self.root=root
        self.root.title('LOGIN')
        self.root.geometry('1500x800+0+0')


        self.bg=ImageTk.PhotoImage(file=r"C:\Users\USER\Desktop\LogInPage\Images\New.jpg")
        lbl_bg=ttk.Label(self.root,image=self.bg)
        lbl_bg.place(x=0,y=0,relwidth=1,relheight=1)

        frame=Frame(self.root,bg="skyblue")
        frame.place(x=500,y=200,width=440,height=450)

        img1=Image.open(r"C:\Users\USER\Desktop\LogInPage\Images\logo.jpg")
        img1=img1.resize((100,100),Image.LANCZOS)
        self.photoimg1=ImageTk.PhotoImage(img1)
        lblimg1=Label(image=self.photoimg1,bg="skyblue",borderwidth=0)
        lblimg1.place(x=660,y=200,width=100,height=100)


        Get_start=Label(frame,text="GET STARTED",font=("times new Roman",20,"bold"),fg="Black",bg="skyblue")
        Get_start.place(x=100,y=100)

        # Label

        UserName=lbl=Label(frame,text="UserName",font=("times new Roman",15,"bold"),fg="black",bg="skyblue")
        UserName.place(x=50,y=140)

        self.txtUser=ttk.Entry(frame,text="UserName",font=("times new Roman",15,"bold"))
        self.txtUser.place(x=40,y=170,width=280)

        UserPass=lbl1=Label(frame,text="Password",font=("times new Roman",15,"bold"),fg="black",bg="skyblue")
        UserPass.place(x=50,y=200)

        self.txtpass=ttk.Entry(frame,text="Password",font=("times new Roman",15,"bold"))
        self.txtpass.place(x=40,y=230,width=280)

           #log in Button
        logibtn=Button(frame, command=self.Log_in ,text="LogIn",font=("times new Roman",15,"bold"),bd=3,relief=RIDGE,fg="black",bg="skyblue")
        logibtn.place(x=150,y=270,width=100,height=40)

        # Register Button
        logibtn=Button(frame, text="NewUserRegister",font=("times new Roman",12),bd=3,borderwidth=0,fg="black",bg="skyblue",activebackground="skyblue")
        logibtn.place(x=30,y=330,width=130)

        # Forgot Password
        logibtn=Button(frame, text="ForgotPassword",font=("times new Roman",12),borderwidth=0,fg="black",bg="skyblue",activebackground="skyblue")
        logibtn.place(x=30,y=360,width=130)


    def Log_in(self):

        if self.txtUser.get()=="" or self.txtpass.get()=="":
            messagebox.showerror("Error","All Fields required")

        elif self.txtUser.get()=="poojalpatil21" and self.txtpass.get()=="pooja@123":
            messagebox.showinfo("Success","WEL-COME")
        else:
            messagebox.showerror("Invalid","Invalid Username Or Password")

if __name__=="__main__":
    root=Tk()
    app=login_window(root)
    root.mainloop()