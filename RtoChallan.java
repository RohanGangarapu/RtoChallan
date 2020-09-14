import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

/* For reference TS07FQ2007*/
class RtoChallan extends JFrame implements ActionListener
{
	JLabel title;
	JLabel cln_no;
	JTextField cln_num;
	JLabel captcha;
	JLabel captcha_val;
	JTextField captcha_num;
	JLabel credits;
	JButton go;
	JButton clr;
	ImageIcon header;
	JLabel header_view;
	
	int ranX, ranY, ranRes;
	String onr_no, onr_name, cno, cdate, ctime, cplace, cpslimits, creason, cimage;
	float camt, tot_amt;
	
	JLabel owner_noField;
	JLabel owner_noValue;
	JLabel owner_nameField;
	JLabel owner_nameValue;
	JLabel challan_no;
	JLabel challan_date;
	JLabel challan_time;
	JLabel challan_place;
	JLabel challan_pslimits;
	JLabel challan_reason;
	JLabel challan_amt;
	JButton img_view;
	JButton pay_bill;
	ImageIcon rules;
	JLabel rules_view;
	
	ImageIcon pic;
	JLabel pic_view;
	
	RtoChallan()
	{
		super("TS Rto eChallan!");
		setLayout(null);
		
		Random rd = new Random();
		ranX = rd.nextInt(10);
		ranY = rd.nextInt(10);
		ranRes = ranX + ranY;
		
		header = new ImageIcon("Rto.PNG");
		header_view = new JLabel(header);
		header_view.setBounds(0,0,800,125);
		
		title = new JLabel("Telangana State RTO e-Challan");
		title.setBounds(300,150,200,50);
		title.setForeground(Color.RED);
		
		cln_no = new JLabel("Enter your vehicle number : ");
		cln_no.setBounds(220,240,280,25);
		cln_no.setForeground(Color.BLUE);
		
		cln_num = new JTextField(10);
		cln_num.setBounds(420,240,100,25);
		
		captcha = new JLabel("Enter the given Captcha : ");
		captcha.setBounds(220,290,150,25);
		captcha.setForeground(Color.BLUE);
		captcha_val = new JLabel(" " + ranX + " + " + ranY + " = ");
		captcha_val.setBounds(370,290,50,25);
		captcha_val.setForeground(Color.MAGENTA);
		captcha_num = new JTextField(10);
		captcha_num.setBounds(420,290,100,25);
		
		credits = new JLabel("©RIVAL Coders. All rights reserved. Developed by Varun,SriCharan,Shashank and Rohan.");
		credits.setBounds(130,450,550,25);
		//credits.setForeground(Color.ORANGE);
		
		go = new JButton("GO");
		go.setBounds(280,350,75,30);
		go.addActionListener(this);
		
		clr = new JButton("Reset");
		clr.setBounds(390,350,75,30);
		clr.addActionListener(this);

		add(title);
		add(header_view);
		add(cln_no);
		add(cln_num);
		add(captcha);
		add(captcha_val);
		add(captcha_num);
		add(go);
		add(clr);
		add(credits);

		setSize(800,550);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	void storeData(String reg_num)
	{
		if(reg_num.equalsIgnoreCase("TS08FD2954"))
		{
			onr_no    = "TS08FD2954";
			onr_name  = "G Rohan";
			cno       = "23580";
			cdate     = "03/12/2018";
			ctime     = "14:35";
			cplace    = "Hyderabad";
			cpslimits = "JNTU Campus";
			creason   = "No Helmet";
			camt      = 500f;
			cimage    = "iOs 097.JPG";
		}
		else if(reg_num.equalsIgnoreCase("MH22D1778"))
		{
			onr_no    = "MH22D1778";
			onr_name  = "G Shivaji";
			cno       = "55368";
			cdate     = "03/10/2018";
			ctime     = "16:05";
			cplace    = "Hyderabad";
			cpslimits = "KPHB Colony";
			creason   = "Wrong Parking";
			camt      = 1500f;
			cimage    = "Santro.JPEG";
		}
		else if(reg_num.equalsIgnoreCase("TS07EG6358"))
		{
			onr_no    = "TS07EG6358";
			onr_name  = "M Varun";
			cno       = "420";
			cdate     = "03/10/2019";
			ctime     = "18:05";
			cplace    = "Hyderabad";
			cpslimits = "Miyapur";
			creason   = "No Helmet";
			camt      = 2500f;
			cimage    = "iOs 012.JPG";
		}
		else
		{
			JOptionPane.showMessageDialog(null,"No Pending Challans","RTO e-Challan",JOptionPane.WARNING_MESSAGE);
			System.exit(0);
		}
	}
	
	void dispChallan()
	{
		//super("TS Rto eChallan!");
		JFrame frame = new JFrame("Challan");
		frame.setLayout(null);
		
		JLabel jl_Challan = new JLabel("Telangana State RTO e-Challan");
		jl_Challan.setBounds(250,20,300,30);
		jl_Challan.setForeground(Color.RED);
		JLabel jl_VehNo   = new JLabel("Vehicle Number     : ");
		jl_VehNo.setBounds(200,250,200,25);
		jl_VehNo.setForeground(Color.BLUE);
		JLabel jl_OnrNme  = new JLabel("Owner Name         : ");
		jl_OnrNme.setBounds(200,280,200,25);
		jl_OnrNme.setForeground(Color.BLUE);
		JLabel jl_CNO     = new JLabel("e-Challan Number   : ");
		jl_CNO.setBounds(200,310,200,25);
		jl_CNO.setForeground(Color.BLUE);
		JLabel jl_DV      = new JLabel("Date of Violation  : ");
		jl_DV.setBounds(200,340,200,25);
		jl_DV.setForeground(Color.BLUE);
		JLabel jl_TV      = new JLabel("Time of Violation  : ");
		jl_TV.setBounds(200,370,200,25);
		jl_TV.setForeground(Color.BLUE);
		JLabel jl_PV      = new JLabel("Place of Violation : ");
		jl_PV.setBounds(200,400,200,25);
		jl_PV.setForeground(Color.BLUE);
		JLabel jl_PSLimit = new JLabel("Traffic PS Limits  : ");
		jl_PSLimit.setBounds(200,430,200,25);
		jl_PSLimit.setForeground(Color.BLUE);
		JLabel jl_VRule   = new JLabel("Violated Rule      : ");
		jl_VRule.setBounds(200,460,200,25);
		jl_VRule.setForeground(Color.BLUE);
		JLabel jl_Amt     = new JLabel("Amount of Challan  : ");
		jl_Amt.setBounds(200,490,200,25);
		jl_Amt.setForeground(Color.BLUE);
		
		owner_noValue    = new JLabel(onr_no);
		owner_noValue.setBounds(350,250,100,25);
		owner_noValue.setForeground(Color.MAGENTA);
		owner_nameValue  = new JLabel(onr_name);
		owner_nameValue.setBounds(350,280,100,25);
		owner_nameValue.setForeground(Color.MAGENTA);
		challan_no       = new JLabel(cno);
		challan_no.setBounds(350,310,100,25);
		challan_no.setForeground(Color.MAGENTA);
		challan_date     = new JLabel(cdate);
		challan_date.setBounds(350,340,100,25);
		challan_date.setForeground(Color.MAGENTA);
		challan_time     = new JLabel(ctime);
		challan_time.setBounds(350,370,100,25);
		challan_time.setForeground(Color.MAGENTA);
		challan_place    = new JLabel(cplace);
		challan_place.setBounds(350,400,100,25);
		challan_place.setForeground(Color.MAGENTA);
		challan_pslimits = new JLabel(cpslimits);
		challan_pslimits.setBounds(350,430,100,25);
		challan_pslimits.setForeground(Color.MAGENTA);
		challan_reason   = new JLabel(creason);
		challan_reason.setBounds(350,460,100,25);
		challan_reason.setForeground(Color.MAGENTA);
		challan_amt      = new JLabel(Float.toString(camt));
		challan_amt.setBounds(350,490,100,25);
		challan_amt.setForeground(Color.MAGENTA);
		img_view         = new JButton("View Image");
		img_view.setBounds(375,530,120,30);
		img_view.addActionListener(this);
		pay_bill         = new JButton("Pay Now");
		pay_bill.setBounds(175,530,120,30);
		pay_bill.addActionListener(this);
		
		rules      = new ImageIcon("Rule2.PNG");
		rules_view = new JLabel(rules);
		rules_view.setBounds(0,0,650,300);
		
		frame.add(jl_Challan);
		frame.add(jl_VehNo);
		frame.add(jl_OnrNme);
		frame.add(jl_CNO);
		frame.add(jl_DV);
		frame.add(jl_TV);
		frame.add(jl_PV);
		frame.add(jl_PSLimit);
		frame.add(jl_VRule);
		frame.add(jl_Amt);
		
		frame.add(owner_noValue);
		frame.add(owner_nameValue);
		frame.add(challan_no);
		frame.add(challan_date);
		frame.add(challan_time);
		frame.add(challan_place);
		frame.add(challan_pslimits);
		frame.add(challan_reason);
		frame.add(challan_amt);
		frame.add(img_view);
		frame.add(pay_bill);
		frame.add(rules_view);
		
		frame.setSize(700,650);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	void proofImg()
	{
		JFrame imgframe = new JFrame("Proof of Challan");
		imgframe.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		pic      = new ImageIcon(cimage);
		pic_view = new JLabel(pic);
		
		imgframe.add(pic_view);
		
		imgframe.setSize(1000,1000);
		imgframe.setVisible(true);
		imgframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String args[])
	{
		new RtoChallan();
	}

	public void actionPerformed(ActionEvent ae)
	{
		try{
			String sname = ae.getActionCommand();
			int temp_res = Integer.parseInt(captcha_num.getText());
			String temp_num = cln_num.getText();
			if(sname.equals("GO"))
			{
				if(temp_res==ranRes)
				{
					storeData(temp_num);
					dispChallan();
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Invalid Captcha!","RTO e-Challan : Error Message!",JOptionPane.ERROR_MESSAGE);
				}
			}
			else if(sname.equals("Reset"))
			{
				cln_num.setText("");
				captcha_num.setText("");
			}
			else if(sname.equals("View Image"))
			{
				proofImg();
			}
			else if(sname.equals("Pay Now"))
			{
				JOptionPane.showMessageDialog(null,"Payment Gateway coming soon...","RTO e-Challan Payment",JOptionPane.WARNING_MESSAGE);
			}
		}catch(Exception e)
		{
			System.err.println(e);
		}
	}
}