import hashlib
import hmac

def sign(message,key):
    signature=hmac.new(key,message.encode(),hashlib.sha256).hexdigest()
    return signature
def verify(message,key,signature):
    expected_signature=sign(message,key)
    return hmac.compare_digest(signature,expected_signature)

message="This is the message to be signed.Kalpana Regmi"
key=b"Kalpana Regmi"
signature=sign(message,key)
print("Signature:",signature)
result=verify(message,key,signature)
print("Verified:",result)
result=verify(message,b"wrong key",signature)
print("Verified with Wrong Key:",result)