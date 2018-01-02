#! /usr/bin/env python
# -*- coding:utf -*-
import sys
import os
sys.path.append('../pytesser/')
import pytesser
import Image
import ImageEnhance  
import ImageFilter 

allFile = os.listdir('img')
for i in allFile:
	
	im = Image.open('img/'+i)
	text = pytesser.image_to_string(im).strip().lstrip()
	print text


# 二值化  
#threshold = 140  
#able = []  
#for i in range(256):  
#    if i < threshold:  
#        table.append(0)  
#    else:  
#        table.append(1)  
  
#由于都是数字  
#对于识别成字母的 采用该表进行修正  
#rep={'O':'0',  
#    'I':'1','L':'1',  
#    'Z':'2',  
#    'S':'8'  
#    };  
  
#def  getCheckcode(name):  
      
    #打开图片  
#    im = Image.open(name)  
    #转化到亮度  
#    imgry = im.convert('L')  
#    imgry.save('g'+name)  
#    #二值化  
#    out = imgry.point(table,'1')  
 #   out.save('b'+name)  
#    #识别  
#    text = pytesser.image_to_string(out)  
    #识别对吗  
#    text = text.strip()  
    #text = text.upper();  
  
 #   for r in rep:  
#        text = text.replace(r,rep[r])  
  
    #out.save(text+'.jpg')  
##    print text  
 #   return text  



