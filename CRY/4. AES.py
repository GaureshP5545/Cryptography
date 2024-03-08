from cryptography.fernet import Fernet
# Generate a random encryption key
key = Fernet.generate_key() 
print(key) 
cipher_suite = Fernet(key)
print(type(cipher_suite))
# Create a Fernet cipher suite
# Specify input and output file paths
input_file = "input.txt"
encrypted_file = "encrypted_file.txt" 
decrypted_file = "decrypted_file.txt"
# Encrypt the input file and save to the encrypted file 
with open(input_file, 'rb') as file: 
    file_data = file.read()
    encrypted_data = cipher_suite.encrypt(file_data)

with open(encrypted_file, 'wb') as file: 
    file.write(encrypted_data)
    print(f"File '{input_file}' encrypted and saved as '{encrypted_file}'")

with open(encrypted_file, 'rb') as file:
    encrypted_data = file.read()
    decrypted_data = cipher_suite.decrypt(encrypted_data)
# Decrypt the encrypted file and save to the decrypted file decrypted_data = cipher_suite.decrypt(encrypted_data)

with open(decrypted_file, 'wb') as file: 
    file.write(decrypted_data)

print(f"File '{encrypted_file}' decrypted and saved as '{decrypted_file}'")