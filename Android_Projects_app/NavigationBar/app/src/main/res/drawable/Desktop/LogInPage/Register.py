from tkinter import*
from tkinter import ttk
from PIL import Image,ImageTk #imprt Background Image pip install pillow
import PIL.Image
from tkinter import messagebox

class Register:
    def __init__(self,root) :
        self.root=root
        self.root.title("Register")
        self.root.geometry("1500x900+0+0")

        # Background Image
        self.bg=ImageTk.PhotoImage(file=r"C:\Users\USER\Desktop\LogInPage\Images\Reg_Bg.jpg")
        lbl_bg=ttk.Label(self.root,image=self.bg)
        lbl_bg.place(x=0,y=0,relwidth=1,relheight=1)

        self.bg1=ImageTk.PhotoImage(file=r"C:\Users\USER\Desktop\LogInPage\Images\Left_bg1.jpg")
        left_bg=ttk.Label(self.root,image=self.bg1)
        left_bg.place(x=30,y=150,width=680,height=550)

        # Main Frame
        frame=Frame(self.root,bg="skyblue")
        frame.place(x=720,y=150,width=520,height=550)

        # labales
        Register_here=lbl=Label(frame,text="REGISTER HERE",font=("times new Roman",20,"bold"),fg="darkgreen",bg="skyblue")
        Register_here.place(x=30,y=20)

        # Labales and Entry
        # FirstName
        Fname=lbl=Label(frame,text="First Name*",font=("times new Roman",15),bg="skyblue")
        Fname.place(x=30,y=90)
        self.txtfname=ttk.Entry(frame,text="First Name*",font=("times new Roman",15,"bold"))
        self.txtfname.place(x=30,y=130,width=200)

        # MiddleName
        Mname=lbl=Label(frame,text="Middle Name*",font=("times new Roman",15),bg="skyblue")
        Mname.place(x=30,y=170)
        self.txtmname=ttk.Entry(frame,text="Middle Name*",font=("times new Roman",15,"bold"))
        self.txtmname.place(x=30,y=210,width=200)

        # LastName
        Lname=lbl=Label(frame,text="Last Name*",font=("times new Roman",15),bg="skyblue")
        Lname.place(x=30,y=250)
        self.txtLname=ttk.Entry(frame,text="Last Name*",font=("times new Roman",15,"bold"))
        self.txtLname.place(x=30,y=290,width=200)

        # Email
        Email=lbl=Label(frame,text="Email Id*",font=("times new Roman",15),bg="skyblue")
        Email.place(x=250,y=90)
        self.txtmail=ttk.Entry(frame,text="Email Id*",font=("times new Roman",15,"bold"))
        self.txtmail.place(x=250,y=130,width=200)

        # Contact
        Contact=lbl=Label(frame,text="Contact*",font=("times new Roman",15),bg="skyblue")
        Contact.place(x=250,y=170)
        self.txtContact=ttk.Entry(frame,text="Contact*",font=("times new Roman",15,"bold"))
        self.txtContact.place(x=250,y=210,width=200)

        # Password
        Password=lbl=Label(frame,text="Password*",font=("times new Roman",15),bg="skyblue")
        Password.place(x=250,y=250)
        self.txtPassword=ttk.Entry(frame,text="Password*",font=("times new Roman",15,"bold"))
        self.txtPassword.place(x=250,y=290,width=200)

        # Security Quetion
        Security=lbl=Label(frame,text="Security Quetion*",font=("times new Roman",15),bg="skyblue")
        Security.place(x=30,y=330)

        # Security Combobox
        self.Combo_security_Q=ttk.Combobox(frame,font=("times new Roman",10),state="readonly")
        self.Combo_security_Q["values"]=("select","What is Your Pet Name","What is Your DOB","Which is Your Favourite Sport")
        self.Combo_security_Q.place(x=30,y=370,width=200)
        self.Combo_security_Q.current(0)

        # Security Answer
        SecurityAns=lbl=Label(frame,text="Security Answer*",font=("times new Roman",15),bg="skyblue")
        SecurityAns.place(x=250,y=330)
        self.txtSecurityAns=ttk.Entry(frame,text="Security Answer*",font=("times new Roman",15,"bold"))
        self.txtSecurityAns.place(x=250,y=370,width=200)

        # Cheak Button
        chkbtn=Checkbutton(frame,text="I agree the terms and conditions",font=("times new Roman",15),bg="skyblue",activebackground="skyblue",onvalue=1,offvalue=0)
        chkbtn.place(x=30,y=410)

        # Button
        img1=Image.open(r"C:\Users\USER\Desktop\LogInPage\Images\Regbtn1.jpg")
        img1=img1.resize((200,40),Image.LANCZOS)
        self.photoimg1=ImageTk.PhotoImage(img1)
        lblimg1=Button(image=self.photoimg1,bg="skyblue",borderwidth=0,activebackground="skyblue",cursor="hand2")
        lblimg1.place(x=820,y=590,width=300,height=100)

if __name__=="__main__":
    root=Tk()
    app=Register(root)
    root.mainloop()