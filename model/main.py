import tensorflow as tf
from keras.models import Sequential
from keras.layers import Dropout, Activation, Dense
from keras.layers import Flatten, Convolution2D, MaxPooling2D, Conv2D
import os, re, glob
import cv2
import numpy as np

groups_folder_path = 'train_data'
categories = ['back', 'left_leg', 'right_leg']

num_classes = len(categories)

image_w = 28
image_h = 28
X = []
Y = []
dtype=tf.float32
for idex, categorie in enumerate(categories):
    label = [0 for i in range(num_classes)]
    label[idex] = 1
    image_dir = groups_folder_path+'/'+ categorie + '/'

    for top, dir, f in os.walk(image_dir):
        for filename in f:
            img = cv2.imread(image_dir + filename)
            img = cv2.resize(img, None, fx=image_w / img.shape[0], fy=image_h / img.shape[1])

            X.append(img / 256)
            Y.append(label)
Xtr = np.array(X)
Ytr = np.array(Y)

X_train, Y_train = Xtr,Ytr

model = Sequential()
model.add(Conv2D(16,3,3, border_mode='same', activation='relu',
                        input_shape=X_train.shape[1:]))
model.add(MaxPooling2D(pool_size=(1, 1)))
model.add(Dropout(0.25))

model.add(Convolution2D(20, 3, 3, border_mode='same', activation='relu'))
model.add(MaxPooling2D(pool_size=(1, 1)))
model.add(Dropout(0.25))

model.add(Convolution2D(64, 3, 3, border_mode='same', activation='relu'))
model.add(MaxPooling2D(pool_size=(1, 1)))
model.add(Dropout(0.25))

model.add(Convolution2D(64, 3, 3, border_mode='same', activation='relu'))
model.add(MaxPooling2D(pool_size=(1, 1)))
model.add(Dropout(0.25))

model.add(Convolution2D(64, 3, 3, activation='relu'))
model.add(MaxPooling2D(pool_size=(1, 1)))
model.add(Dropout(0.25))

#Classifier
model.add(Flatten())
model.add(Dense(200, activation = 'relu'))
model.add(Dense(3,activation = 'softmax'))
model.summary()
model.compile(loss='mean_squared_error',optimizer='Adam', metrics=['accuracy'])
hist=model.fit(X_train, Y_train, batch_size=40, nb_epoch=20)

model.save('8LBMI3.h5')