import sys
sys.dont_write_bytecode = True
import building
import xml.etree.cElementTree

ID = input('ID: ')
floor = input('Number of Floors: ')
addr = input('Address: ')
b = building.Building(ID, floor, addr)

tree = xml.etree.cElementTree.parse('5.xml')
root = tree.getroot()
xml.etree.cElementTree.SubElement(root, 'building', ID=b.ID, numberOfFloors=b.floor, address=b.addr).text = ' '
tree.write('5.xml')