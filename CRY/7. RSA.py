import math
p = int(input("Enter 1st Prime Number"))
print("Prime Numbers:") 
print("1st Prime Number:",p) 
q = int(input("Enter 2nd Prime Number"))
print("2nd Prime Number:",q)

if not (p> 1 and q > 1 and math.gcd(p, q) == 1): 
    print("Both p and q should be prime numbers and coprime.")
else:
    n = p * q
    fact = (p - 1) * (q -1)
    
    print("Multiply =", n) 
    print("Factor =", fact)

    e=int(input("Enter e for RSA: ")) 
    while math.gcd(e, fact) != 1: 
        e = int(input("e must be coprime to the factor: "))

    print("Encrypted Key = ", e)

    d=1 
    while (d * e) % fact != 1: 
        d += 1

    print("Private Key =", d)

    pt = int(input("Enter plain text: ")) 
    print("Plain Text :",pt) 
    
    ct = pow(pt, e)% n
    print("Cipher text =", ct) 
    print("Send", ct, "to the receiver")

    ans = pow(ct, d)%n 
    print("Decrypted text =", ans)