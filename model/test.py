import os, re, glob
import cv2
import numpy as np
import shutil
from numpy import argmax
from keras.models import load_model

categories = ['back', 'left_leg', 'right_leg']


def Dataization(img_path):
    image_w = 28
    image_h = 28
    img = cv2.imread(img_path)
    img = cv2.resize(img, None, fx=image_w / img.shape[1], fy=image_h / img.shape[0])
    return (img / 256)


src = []
name = []
test = []
test.append(Dataization('test.jpg'))

test = np.array(test)

model = load_model('8LBMI3.h5')
predict = model.predict_classes(test)

for i in range(len(test)):
    print(name[i] + " : , Predict : " + str(categories[predict[i]]))
