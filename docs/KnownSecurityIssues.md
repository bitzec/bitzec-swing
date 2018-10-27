## [Bitzec Swing Wallet](https://swing.bitzec.com/) known security issues

This document describes various security-related vulnerabilities in the GUI wallet that have become known after release and users should be aware of them!

### Compatibility with other applications

The Zcash Desktop GUI Wallet is not compatible with applications that modify the Zcash `wallet.dat` file. The wallet should not be used
with such applications on the same PC. For instance some distributed exchange applications are known to create watch-only addresses in the
`wallet.dat` file that cause the GUI wallet to display a wrong balance and/or display addresses that do not belong to the wallet. 

### Disclaimer

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
