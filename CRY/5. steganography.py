from PIL import Image
import stepic

def encode(a,message):
    im=Image.open(a)
    im1=stepic.encode(im,message)
    im1.save('modified_image.png','PNG')
def decode(b):
    image=Image.open(b)
    message=stepic.decode(image)
    return message
if __name__=='__main__':
    a="flowers.png"
    message=b'Welcome'
    encode(a,message)
    print('Message encoded successfully in the image')
    b='modified_image.png'
    message=decode(b)
    print('Decoded message:',message)