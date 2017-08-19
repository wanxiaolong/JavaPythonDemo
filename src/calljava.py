from com.my.py import HelloWorld

#The [name] variable is set in Java through PythonInterpreter
print("2.In Python------Parameter [name] is set to [%s]" % name)
hello = HelloWorld()

print("3.In Python------Now calling Java")
hello.sayHello(name)
print("5.In Python------Exit Python environment")
