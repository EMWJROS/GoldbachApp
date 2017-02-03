/*##############################################################################
################################################################################
################################################################################
#############################MMF'       ````""S########MNBPBK###################
#############################Man.              4##########EkMMK#################
##############################kpav,             "T9########MENNM################
###############################Mbpvx              5J######BBMMPkBKM#############
#############################NH$p#/`"              "T#####pJMF+4kNNNEBK#########
#########################MMMMTEELm'                 aJ######Mm,n74W9SWFSK#######
#########################MMm44Hm".                  `j#######M##n"**&14FPK######
####################M#####F4####bp####pg,           `4##########pcvnn7CTTk######
#########################################px.         7##############Wc%V$BK#####
###########################################kg       ,aJ4##########MM##baNBB#####
############################MTK#M#####MM#####Wn'      "*9###MMMb4######WSk######
###########################M   "K###MMM#MU=             |4##"jU4#####MW4SBKBK###
######################MM##M       77MTV~`               j##M"n ####M#En%7K#B####
#########################Mm      `&,                   ^##M.  &#####KMkpa#######
################################msSK#v,               ,4M`s  a#######MK#K#######
#############################MF"   "S#bp>,            $[/,,a##MMMT7PE###########
#############################Mb<~ ;(pSNWLm>           K########Bn*,&4###########
##############################MMMMMM##W74pm           "###M######m4S############
##################M###########L`     7Pm:`.           aBBK######################
################M########MMTT7"       `"\.            :4########################
#########################m`;a/        ``(U;=       ,;*  ########################
########################F"  ""'          ,;  .  ,%v"   #########################
######################MMm,,             ..,vag*/**   a##########################
###########################pn%vg,, ^,vvd74kACn-"   ,############################
#########################M#MM$p#EppJ4####M7n"     a#############################
#####################################MMM*"      ,###############################
##################################M]].         a################################
########################M###############,    ,##################################
################################################################################
################################################################################
################################################################################
#########################MMMK########M##########################################
#######################MMS"     :    `j#########################################
#######################MhE;m    n    a##########################################
########################WFjL   `.   ############################################
########################MhjWj  ;   #############################################
#########################L4WL  ` ,##############################################
##########################A4P   a###############################################
###########################4m  #################################################
############################La##################################################

                                    BY

      a######n ###m    a######  ;##   ##   ### ,#######,   a####m   ,######c
     a##  ,/" ######a##M#####M  ###  j#M   ### ##M  v##M ##M   j## ###,   F.
    ,###MKM   ##  K##M j#####  ,##M  #M    ##F$######M\ ##F     ##M !7MK###
    ##F      [##   KM  ### #####K##a#M  #v### ##M: K##m4##M    #####a,,,a##M
   ;KKKKKKKKMKKKn     #KKM "#M"  ?#M\  9K##M  KKH   KKK *######MM 7KK###M"*/



package com.surimisoft.goldbachapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.EditText;

public class GoldbachActivity extends Activity {
	
	private Button mSearchButton;
	private Button mDoneButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_goldbach);
		
		mSearchButton  = (Button) findViewById( R.id.start_button );
		mSearchButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
				int maxNum;
				EditText searchBox = (EditText) findViewById( R.id.search_limit);
				try {
					maxNum = Integer.parseInt(searchBox.getText().toString());
				}
				catch (NumberFormatException e) {
					maxNum = Integer.parseInt(getString(R.string.default_limit));
				}
				new Thread(new GoldbachSearch(maxNum, GoldbachActivity.this, searchBox)).start();

			}
		});
		
		mDoneButton = (Button) findViewById( R.id.done_button ); 
		mDoneButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.goldbach, menu);
		return true;
	}

}
